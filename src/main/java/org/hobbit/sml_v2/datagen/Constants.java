package org.hobbit.sml_v2.datagen;

public class Constants {
    // =============== STRUCTURED DATA GENERATOR CONSTANTS ===============
    public static final String GENERATOR_SEED_KEY = "GENERATOR_SEED";
    public static final String GENERATOR_POPULATION_KEY = "GENERATOR_POPULATION";
    public static final String GENERATOR_DATASET_KEY = "GENERATOR_DATASET";
    public static final String GENERATOR_MIMICKING_OUTPUT_KEY = "GENERATOR_MIMICKING_OUTPUT";
    public static final String GENERATOR_INSERT_QUERIES_COUNT_KEY = "GENERATOR_INSERT_QUERIES_COUNT";
    public static final String GENERATOR_BENCHMARK_DURATION_KEY = "GENERATOR_BENCHMARK_DURATION";

    public static final String OUTPUT_FORMAT_KEY ="OUTPUT_FORMAT";

    public static final String DATASET_FILE_NAME = "data/debs2018_fixed_3_labeled_v8_training.csv";
    //public static final String DATASET_FILE_NAME = "data/debs2018_complete_fixed_3_labeled_v8_test_20.csv";


    public static String GIT_REPO_PATH = "git.project-hobbit.eu:4567/smirnp/";
    public static String PROJECT_NAME = "sml-v2-";

    public static final String DATAGEN_IMAGE_NAME = GIT_REPO_PATH+PROJECT_NAME +"datagen";
}
