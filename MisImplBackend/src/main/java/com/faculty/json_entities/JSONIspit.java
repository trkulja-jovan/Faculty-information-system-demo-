package com.faculty.json_entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONIspit(@JsonProperty Integer ocena,
						@JsonProperty String datum,
						@JsonProperty JSONPredmet predmet,
						@JsonProperty JSONStudent student) {

}
