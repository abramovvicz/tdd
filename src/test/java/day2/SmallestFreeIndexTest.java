package day2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SmallestFreeIndexTest {

    SmallestFreeIndex smallestFreeIndex;

    @BeforeEach
    void setUp() {
        smallestFreeIndex = new SmallestFreeIndex();
    }


    @Test
    void getIndex() {
        int[] table = {5, 3, 1};
        assertThat(smallestFreeIndex.getIndex(table)).isEqualTo(2);
    }

    @Test
    void getIndex1() {
        int[] table = {};
        assertThat(smallestFreeIndex.getIndex(table)).isEqualTo(1);
    }

    @Test
    @DisplayName("should be 1")
    void getIndex2() {
        int[] table = {-5, -3, -1, 0};
        assertThat(smallestFreeIndex.getIndex(table)).isEqualTo(1);
    }

    @Test
    void getIndex3() {
        int[] table = {5, 3, 1, 1, -3, 0, -5};
        assertThat(smallestFreeIndex.getIndex(table)).isEqualTo(2);
    }

    @Test
    void getIndex4() {
        int[] table = {3, 2, 1, 1, 0, 4, 5, -3};
        assertThat(smallestFreeIndex.getIndex(table)).isEqualTo(6);
    }
}