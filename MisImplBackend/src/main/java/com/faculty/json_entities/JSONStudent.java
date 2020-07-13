package com.faculty.json_entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public record JSONStudent(@JsonProperty int idOsoba,
						  @JsonProperty String brIndeksa,
						  @JsonProperty int godinaStudija,
						  @JsonProperty String ime,
						  @JsonProperty String jmbg,
						  @JsonProperty String prezime) implements JsonEntity {


}