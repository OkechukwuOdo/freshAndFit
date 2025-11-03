package com.tripleOtech.freshAndFit.service.implementation;

import com.tripleOtech.freshAndFit.dto.requestDtos.PackRequest;
import com.tripleOtech.freshAndFit.dto.responseDtos.PackResponse;
import com.tripleOtech.freshAndFit.dto.responseDtos.PackStatusResponse;
import com.tripleOtech.freshAndFit.entity.AppUser;
import com.tripleOtech.freshAndFit.entity.PackageStatus;
import com.tripleOtech.freshAndFit.repository.AppUserRepository;
import com.tripleOtech.freshAndFit.repository.PackRepository;
import com.tripleOtech.freshAndFit.repository.PackStatusRepository;
import com.tripleOtech.freshAndFit.service.PackService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PackServiceImplementation implements PackService {
    private final AppUserRepository appUserRepository;
    private final PackRepository packRepository;
    private final PackStatusRepository packStatusRepository;
    @Override
    public PackResponse createPack(PackRequest packRequest) {
        return null;
    }

    @Override
    public PackStatusResponse updatePackStatusAfterPayment(String userEmail, Long packId) {
        AppUser appUser=appUserRepository.findByEmail(userEmail).orElseThrow();
        Pack pack=packRepository.findById(packId).orElseThrow();
        PackageStatus packageStatus= pack.getPackageStatus();
        List<AppUser> appUserList= packageStatus.getParticipants();
        if (appUserList==null){
            appUserList=new ArrayList<>();
        }
        appUserList.add(appUser);
        packageStatus.setParticipants(appUserList);
        packageStatus.setNumberOfPeopleRemaining(packageStatus.getNumberOfPeopleRemaining()-1);
       PackageStatus newPackageStatus= packStatusRepository.save(packageStatus);

        return PackStatusResponse.packStatusResponseInstance(newPackageStatus);
    }
    @Scheduled(cron = "0 0 0 * * *")
    public void updateRemainingDaysForPackage(){
        List<Pack> packList =packRepository.findAll();
        if (packList.isEmpty()){
            return;
        }
        for (Pack pack: packList){
            if (pack.getScheduledAt().isAfter(LocalDateTime.now())){
                PackageStatus packageStatus= pack.getPackageStatus();
                packageStatus.setNumberOfDaysLeft(pack.getPackageStatus().getNumberOfDaysLeft()-1);
                pack.setPackageStatus(packageStatus);
            }
        }
    }
}
