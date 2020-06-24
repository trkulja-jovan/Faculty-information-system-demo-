package com.faculty.json_entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONPredProf(@JsonProperty JSONPredmet pred, @JsonProperty JSONProfesor prof) {

}
