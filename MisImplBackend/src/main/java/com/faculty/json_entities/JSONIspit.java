package com.faculty.json_entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONIspit(@JsonProperty Integer idIspit,
						@JsonProperty Integer ocena,
						@JsonProperty String predmet,
						@JsonProperty String datum) {

}
