package com.faculty.json_entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONPredmet(@JsonProperty int idPredmet,
						  @JsonProperty int espb,
						  @JsonProperty String nazivPredmeta,
						  @JsonProperty int semestar) implements JsonEntity{

}


