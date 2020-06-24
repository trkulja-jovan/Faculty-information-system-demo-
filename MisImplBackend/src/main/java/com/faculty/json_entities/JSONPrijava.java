package com.faculty.json_entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONPrijava(
		@JsonProperty int idPrijava,
		@JsonProperty String ispitniRok,
		@JsonProperty JSONIspit ispit,
		@JsonProperty JSONStudent student) {

}
