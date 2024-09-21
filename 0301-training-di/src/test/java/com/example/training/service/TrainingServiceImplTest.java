package com.example.training.service;

import java.util.List;

import com.example.training.repository.TrainingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.training.entity.Training;

class TrainingServiceImplTest {
    @Test
    public void test_findAll() {
//        修正前
//        TrainingService trainingService = null;

//        修正後
        TrainingRepository trainingRepository = new MockTrainingRepository();
        TrainingService trainingService = new TrainingServiceImpl(trainingRepository);

        List<Training> trainings = trainingService.findAll();
        // 結果の確認
        Assertions.assertThat(trainings.size()).isEqualTo(10);
    }
}