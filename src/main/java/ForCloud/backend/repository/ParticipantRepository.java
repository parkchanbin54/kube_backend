package ForCloud.backend.repository;

import ForCloud.backend.entity.Chatting;
import ForCloud.backend.entity.Participant;
import ForCloud.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {


//    @Query("select p from Participant p inner join p.post.participants participants where participants.chatting = ?1")
//    List<Participant> findByPost_Participants_Chatting(Chatting chatting);
//
//    @Query("select p from Participant p inner join p.post.participants participants where participants.user = ?1")
//    List<Participant> findByPost_Participants_User(User user);
//
//    @Query("select p from Participant p where p.user.id = ?1")
//    List<Participant> findByUserId(Long userId);
//
//
//    @Query("select p from Participant p inner join p.post.participants participants " +
//            "where participants.user = ?1 and participants.chatting = ?2")
//    Participant findByPost_Participants_UserAndPost_Participants_Chatting(User user, Chatting chatting);


    List<Participant> findAllByUser_Id(Long memberId);
    List<Participant> findAllByChatting_Id(Long chattingId);
    @Query("select p from Participant p where p.user.id = ?1 and p.chatting.id =?2")
    Participant findByUser_IdAndChatting_Id(Long memberId,Long chattingId);

    @Query("select p from Participant p where p.post.id = ?1 and p.user.id =?2")
    Optional<Participant> findByPost_User_Id(Long postId, Long UserId);


}
