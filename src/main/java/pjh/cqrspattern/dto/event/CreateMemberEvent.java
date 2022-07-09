package pjh.cqrspattern.dto.event;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter
@Getter
public class CreateMemberEvent {

    private String account_id;

    private String roleId;

    private String userName;

    private String userDescription;

    @SuppressWarnings("unchecked")
    @JsonProperty("payload")
    private void unpackNested(Map<String,Object> payload) {
        Map<String,String> after = (Map<String,String>)payload.get("after");
        this.account_id=after.get("account_id");
        this.roleId=after.get("role_id");
        this.userName=after.get("user_name");
        this.userDescription=after.get("user_description");
    }

    @Override
    public String toString() {
        return "CreateMemberEvent{" +
                "accountId='" + account_id + '\'' +
                ", roleId='" + roleId + '\'' +
                ", userName='" + userName + '\'' +
                ", userDescription='" + userDescription + '\'' +
                '}';
    }
}
