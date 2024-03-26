package com.yash.actormovie.repository;

import com.yash.actormovie.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {


}
