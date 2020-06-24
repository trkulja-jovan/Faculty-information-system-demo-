package com.faculty.json_entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONProfesor(
		@JsonProperty int idProfesor,
		@JsonProperty String ime,
		@JsonProperty String jmbg,
		@JsonProperty String prezime) {

}