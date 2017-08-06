package rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.mockito.runners.MockitoJUnitRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.capgemini.chees.enums.MatchResult;
import com.capgemini.chess.rest.ChessRestService;
import com.capgemini.chess.service.impl.RankingFacadeImpl;
import com.capgemini.chess.service.to.MatchTO;
import com.capgemini.chess.service.to.RankingRowTO;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RestServiceTest {

	@Mock
	private RankingFacadeImpl facade;

	@InjectMocks
	ChessRestService service;

	private MockMvc mockMvc;

	@Before
	public void setUp() {

		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(service).build(); // atrapa
																	// mockmvc
	}

	@Test
	public void getRankingTest() throws Exception {

		// given
		RankingRowTO rankingRow = new RankingRowTO(1L, "zuczek", 622);
		RankingRowTO rankingRow2 = new RankingRowTO(2L, "myszka", 433);

		List<RankingRowTO> ranking = new ArrayList<RankingRowTO>();
		ranking.add(rankingRow);
		ranking.add(rankingRow2);
		when(facade.getRanking()).thenReturn(ranking);

		// when
		ResultActions response = this.mockMvc.perform(
				get("/get_ranking").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON));

		// then
		response.andExpect(status().isOk()).andExpect(jsonPath("[0].id").value((int) rankingRow.getId()))
				.andExpect(jsonPath("[0].login").value(rankingRow.getLogin()))
				.andExpect(jsonPath("[0].points").value(rankingRow.getPoints()));

	}

	@Test
	public void getUserRankingTest() throws Exception {
	
		// given
		RankingRowTO rankingRow = new RankingRowTO(2L,"muszka",620);
		List<RankingRowTO> ranking = new ArrayList<RankingRowTO>();
		ranking.add(new RankingRowTO(3L,"slonik",622));
		ranking.add(new RankingRowTO(15L,"grzybek",621));
		ranking.add(rankingRow);
		ranking.add(new RankingRowTO(4L,"witek",619));
		ranking.add(new RankingRowTO(29L,"bonifacy",618));		

		//when
		when(facade.getUserRanking(2L)).thenReturn(ranking);
		ResultActions response = this.mockMvc.perform(get("/get_user_ranking/2").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON));
		
		//then
		response.andExpect(status().isOk())
		.andExpect(jsonPath("[2].id").value((int)rankingRow.getId()))
		.andExpect(jsonPath("[2].login").value(rankingRow.getLogin()))
		.andExpect(jsonPath("[2].points").value(rankingRow.getPoints()));
		
	}

	@Test
	public void registerMatchResultTest() throws Exception {

		// given
		MatchTO match = new MatchTO(1L, 10L, 13L, MatchResult.WON_USER_FIRST);

		// when
		when(facade.registerMatchResult(MatchResult.WON_USER_FIRST, 1L)).thenReturn(match);
		ResultActions response = this.mockMvc.perform(post("/register_match_result")
				.param("matchResult", MatchResult.WON_USER_FIRST.toString()).param("id", "1"));

		// then
		response.andExpect(status().isOk()).andExpect(jsonPath("id").value((int) match.getId()))
				.andExpect(jsonPath("userFirstId").value((int) match.getUserFirstId()))
				.andExpect(jsonPath("userSecondId").value((int) match.getUserSecondId()))
				.andExpect(jsonPath("matchStatus").value(match.getMatchStatus().toString()));

	}

}
