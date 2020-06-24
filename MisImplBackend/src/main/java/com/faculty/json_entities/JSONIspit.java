package com.faculty.json_entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONIspit(@JsonProperty int idIspit,
						@JsonProperty int ocena,
						@JsonProperty Date datumPolaganja,
						@JsonProperty JSONPredmet predmet,
						@JsonProperty JSONStudent student) {

}

