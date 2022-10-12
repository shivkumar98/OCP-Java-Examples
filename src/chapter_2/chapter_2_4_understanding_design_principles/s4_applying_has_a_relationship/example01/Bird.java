package chapter_2.chapter_2_4_understanding_design_principles.s4_applying_has_a_relationship.example01;

/* Bird HAS-A Beak*/
public class Bird {
	Beak beak;
}

class Beak  {}

/* Composition enforces that child classes of Bird must also have a Beak*/