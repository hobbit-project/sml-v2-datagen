package org.hobbit.sml_v2.datagen;

import org.hobbit.smlbenchmark_v2.benchmark.generator.TaskGenerator;
import org.junit.contrib.java.lang.system.EnvironmentVariables;

import static org.hobbit.core.Constants.DATA_QUEUE_NAME_KEY;
import static org.hobbit.sml_v2.datagen.Constants.DATASET_FILE_NAME;
import static org.hobbit.smlbenchmark_v2.Constants.DATASET_FILE_NAME_KEY;

public class DataGeneratorRunner {

    public static final String GENERATOR_SEED_KEY = "GENERATOR_SEED";
    public static final String GENERATOR_POPULATION_KEY = "GENERATOR_POPULATION";
    public static final String GENERATOR_DATASET_KEY = "GENERATOR_DATASET";
    public static final String GENERATOR_MIMICKING_OUTPUT_KEY = "GENERATOR_MIMICKING_OUTPUT";
    public static final String GENERATOR_INSERT_QUERIES_COUNT_KEY = "GENERATOR_INSERT_QUERIES_COUNT";
    public static final String GENERATOR_BENCHMARK_DURATION_KEY = "GENERATOR_BENCHMARK_DURATION";

    public static final String OUTPUT_FORMAT_KEY ="OUTPUT_FORMAT";

    public static void main(String[] args) throws Exception {
        EnvironmentVariables environmentVariables = new EnvironmentVariables();

        environmentVariables.set("HOBBIT_GENERATOR_ID", "1");
        environmentVariables.set("HOBBIT_GENERATOR_COUNT", "1");
        environmentVariables.set("HOBBIT_RABBIT_HOST", "rabbit");
        environmentVariables.set("QUERY_TYPE", "1");
        environmentVariables.set(DATASET_FILE_NAME_KEY, DATASET_FILE_NAME);


        if(!System.getenv().containsKey(OUTPUT_FORMAT_KEY))
            throw new Exception(OUTPUT_FORMAT_KEY +" is not defined");

        if(System.getenv().containsKey(GENERATOR_POPULATION_KEY))
            environmentVariables.set("TUPLES_LIMIT", System.getenv().get(GENERATOR_POPULATION_KEY));

        if(!System.getenv().containsKey(DATA_QUEUE_NAME_KEY))
            throw new Exception(DATA_QUEUE_NAME_KEY+" is not defined");


        environmentVariables.set("DATA_FORMAT", System.getenv().get(OUTPUT_FORMAT_KEY));

        String queueName = System.getenv().get(DATA_QUEUE_NAME_KEY);

        TaskGenerator taskGenerator = new TaskGenerator();

        taskGenerator.init();
        taskGenerator.generateData();
        taskGenerator.sendDataToSimpleFileSender();
        taskGenerator.close();
        System.exit(0);
    }
}
