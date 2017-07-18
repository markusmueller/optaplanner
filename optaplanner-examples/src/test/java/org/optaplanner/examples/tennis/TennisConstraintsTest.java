package org.optaplanner.examples.tennis;

import org.junit.Test;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.tennis.domain.Team;
import org.optaplanner.examples.tennis.domain.TeamAssignment;
import org.optaplanner.examples.tennis.domain.TennisSolution;
import org.optaplanner.test.impl.score.buildin.hardmediumsoft.HardMediumSoftScoreVerifier;

import java.util.Arrays;
import java.util.Collections;

public class TennisConstraintsTest {

    private HardMediumSoftScoreVerifier<TennisSolution> scoreVerifier = new HardMediumSoftScoreVerifier<>(
            SolverFactory.createFromXmlResource("org/optaplanner/examples/tennis/solver/tennisSolverConfig.xml"));

    @Test
    public void fairAssignmentCountPerTeam() {
        TeamAssignment assignment1 = new TeamAssignment();
        assignment1.setId(0L);

        TeamAssignment assignment2 = new TeamAssignment();
        assignment2.setId(1L);

        Team team1 = new Team();
        team1.setId(0L);

        Team team2 = new Team();
        team2.setId(1L);

        TennisSolution tennisSolution = new TennisSolution();
        tennisSolution.setTeamList(Arrays.asList(team1, team2));
        tennisSolution.setTeamAssignmentList(Arrays.asList(assignment1, assignment2));

        // Not relevant for testcase
        tennisSolution.setDayList(Collections.emptyList());
        tennisSolution.setUnavailabilityPenaltyList(Collections.emptyList());

        scoreVerifier.assertSoftWeight("fairAssignmentCountPerTeam", 0, tennisSolution);
    }
}
