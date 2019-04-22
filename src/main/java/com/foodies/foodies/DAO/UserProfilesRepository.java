package com.foodies.foodies.DAO;

import com.foodies.foodies.Models.UserProfile;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfilesRepository extends PagingAndSortingRepository<UserProfile,Long> {
}
