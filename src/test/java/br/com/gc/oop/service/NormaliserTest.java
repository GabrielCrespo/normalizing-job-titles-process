package br.com.gc.oop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NormaliserTest {

    private Normaliser normaliser;

    @BeforeEach
    public void SetUp() {
        normaliser = new Normaliser();
    }

    @Test
    public void shouldNormaliseNameWithEngineerToSoftwareEngineer() {

        String jt = "Java Engineer";
        String expectedNormalisedJob = "Software engineer";

        String jobTitleNormalised = normaliser.normalise(jt);

        Assertions.assertEquals(expectedNormalisedJob, jobTitleNormalised);

    }

    @Test
    public void shouldNormaliseNameWithArchitectToArchitect() {

        String jt = "Senior Architect";
        String expectedNormalisedJob = "Architect";

        String jobTitleNormalised = normaliser.normalise(jt);

        Assertions.assertEquals(expectedNormalisedJob, jobTitleNormalised);

    }

    @Test
    public void shouldNormaliseNameWithAccountantToAccountant() {

        String jt = "Chief Accountant";
        String expectedNormalisedJob = "Accountant";

        String jobTitleNormalised = normaliser.normalise(jt);

        Assertions.assertEquals(expectedNormalisedJob, jobTitleNormalised);

    }

    @Test
    public void shouldNormaliseNameWithQuantitySurveyorToQuantitySurveyor() {

        String jt = "Senior Quantity Surveyor";
        String expectedNormalisedJob = "Quantity surveyor";

        String jobTitleNormalised = normaliser.normalise(jt);

        Assertions.assertEquals(expectedNormalisedJob, jobTitleNormalised);

    }

    @Test
    public void shouldNormaliseThrowsNullPointerExceptionWhenInputIsNull() {
        Assertions.assertThrows(NullPointerException.class,
                () -> normaliser.normalise(null));

    }

    @Test
    public void shouldNormaliseThrowsIllegalArgumentExceptionWhenInputIsEmpty() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> normaliser.normalise(""));

    }

    @Test
    public void shouldNormaliseThrowsIllegalArgumentExceptionWhenInputIsBlank() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> normaliser.normalise(""));

    }

}
