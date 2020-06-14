package com.team.house_backapi.service;

import com.team.house_backapi.domain.Street;

import java.util.List;

public interface StreetService {
    List<Street> getStreetsByDisid(Integer disid);
}
