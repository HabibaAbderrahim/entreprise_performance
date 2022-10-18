package jci.entreprise.performance.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@NoArgsConstructor
public class CommentDTO {
    private Long comId;
    private Long postId;
    private Long userId;
    private Instant createDate;
    private String text;

    public CommentDTO(Long comId, Long postId, Long userId, Instant createDate, String text) {
        this.comId = comId;
        this.postId = postId;
        this.userId = userId;
        this.createDate = createDate;
        this.text = text;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
