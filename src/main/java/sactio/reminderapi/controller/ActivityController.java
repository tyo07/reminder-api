package sactio.reminderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import sactio.reminderapi.dto.ActivityDto;
import sactio.reminderapi.dto.ActivityRequestDto;
import sactio.reminderapi.dto.ActivityResponseDto;
import sactio.reminderapi.service.impl.ActivityServiceImpl;

@RestController
public class ActivityController {

    final ActivityServiceImpl activityServiceImpl;

    @Autowired
    public ActivityController(final ActivityServiceImpl activityServiceImpl) {
        this.activityServiceImpl = activityServiceImpl;
    }

    @GetMapping("/api/activity/get/{activity}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityDto> getActivity(@PathVariable Integer activity) {
        ActivityResponseDto<ActivityDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage("Success");
        activityResponseDto.setData(activityServiceImpl.getActivityById(activity));
        return activityResponseDto;
    }

    @GetMapping("/api/activity/get")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityDto> getAllActivity() {
        ActivityResponseDto<ActivityDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage("Success");
        activityResponseDto.setData(activityServiceImpl.getAllActivities());
        return activityResponseDto;
    }


    @PostMapping("/api/activity/insert")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ActivityResponseDto<ActivityDto> insertActivity(@RequestBody ActivityRequestDto activityRequestDto) {
        activityServiceImpl.insertActivity(activityRequestDto);
        ActivityResponseDto<ActivityDto> activityResponseDto = new ActivityResponseDto<>();
        activityResponseDto.setResponseCode(200);
        activityResponseDto.setMessage(activityRequestDto + " successfully inserted.");
        activityResponseDto.setData(null);
        return activityResponseDto;
    }


}
