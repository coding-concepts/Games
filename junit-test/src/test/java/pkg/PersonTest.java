package pkg;


import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class PersonTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass:");
    }
    @Before
    public void before() {
        System.out.println("@BeforeEach:");
    }

    @Test(expected = RuntimeException.class)
    public void testNullName() {
        Person p = new Person(null, 10);
    }

    @Test(expected = RuntimeException.class)
    public void testAddAgeMoreThan150(){
        Person p = new Person("Hopkins", 10);
        p.growUp(150);
    }


    @Test
    public void testCreation(){

        Person p = new Person("John", 60);

        p.growUp(10);


        assertEquals("John", p.getName());

        assertThat(p.getName()).isEqualTo("John");

        assertEquals(70, p.getAge());


        assertThat(p.getName()) .isEqualTo("John");

        assertThat(p.getAge()).isEqualTo(60);



    }







}
