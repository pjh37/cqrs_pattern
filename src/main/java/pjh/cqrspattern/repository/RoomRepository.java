package pjh.cqrspattern.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pjh.cqrspattern.domain.Room;

public interface RoomRepository extends JpaRepository<Room,String> {
}
