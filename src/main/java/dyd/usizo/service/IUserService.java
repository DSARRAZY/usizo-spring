package dyd.usizo.service;

import dyd.usizo.models.User;

public interface IUserService {
    User findByUsername(String username);
}