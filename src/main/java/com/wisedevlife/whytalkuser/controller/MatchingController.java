package com.wisedevlife.whytalkuser.controller;

import com.wisedevlife.whytalkuser.common.helper.ResponseHandler;
import com.wisedevlife.whytalkuser.dto.request.MatchingRequest;
import com.wisedevlife.whytalkuser.dto.response.ReturnResponse;
import com.wisedevlife.whytalkuser.model.MatchingFilter;
import com.wisedevlife.whytalkuser.service.MatchingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Range;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
@RequiredArgsConstructor
public class MatchingController {
    private final MatchingService matchingService;

    @PostMapping()
    public ResponseEntity<ReturnResponse<Object>> startMatchUserProcess(
            @RequestBody MatchingRequest matchingRequest) {
        String currentUserId = matchingRequest.getUserId();
        Range<Integer> ageRange =
                Range.closed(
                        matchingRequest.getAgeRange().getLowerBound(),
                        matchingRequest.getAgeRange().getUpperBound());

        MatchingFilter filter =
                MatchingFilter.builder()
                        .ageRange(ageRange)
                        .genderOptions(matchingRequest.getGenderOptions())
                        .build();

        matchingService.startMatchingProcess(currentUserId, filter);

        return ResponseHandler.success();
    }
}
