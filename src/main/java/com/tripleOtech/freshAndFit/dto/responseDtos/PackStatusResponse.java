package com.tripleOtech.freshAndFit.dto.responseDtos;

import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.PackageStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PackStatusResponse {
    private Long id;
    private String name;
    private String image;
    private Integer quantity;
    private Integer numberOfPersonRequired;
    private Integer numberOfPersonAvailable;
    private int numberOfPeopleRemaining;
    private Double totalAmount;
    private Double amountPerPerson;
    private LocalDateTime scheduledAt;
    private int numberOfDaysLeft;
    private List<AppUser> participants;

    private PackStatusResponse(PackageStatus packageStatus){
        id=packageStatus.getId();
        name= packageStatus.getName();
        image= packageStatus.getImage();
        numberOfPersonRequired=packageStatus.getNumberOfPersonRequired();
        numberOfPersonAvailable=packageStatus.getNumberOfPersonAvailable();
        numberOfPeopleRemaining=packageStatus.getNumberOfPeopleRemaining();
        totalAmount=packageStatus.getTotalAmount();
        amountPerPerson=packageStatus.getAmountPerPerson();
        scheduledAt=packageStatus.getScheduledAt();
        numberOfDaysLeft=packageStatus.getNumberOfDaysLeft();
        participants=packageStatus.getParticipants();
    }
    public static PackStatusResponse packStatusResponseInstance(PackageStatus packageStatus){
        return new PackStatusResponse(packageStatus);
    }
}
