package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun("Bun", 35);
    }

    @Test
    public void testBunConstructor() {
        assertEquals("Bun", bun.getName());
        assertEquals(35, bun.getPrice(), 0.0);
    }

    @Test
    public void testGetName() {
        assertEquals("Bun", bun.getName());
    }

    @Test
    public void testGetPrice() {
        assertEquals(35, bun.getPrice(), 0.0);
    }

    @Test
    public void testWithMock() {
        Bun mockBun = mock(Bun.class);
        when(mockBun.getName()).thenReturn("Imitation");
        when(mockBun.getPrice()).thenReturn(3.5F);
        assertEquals("Imitation", mockBun.getName());
        assertEquals(3.5F, mockBun.getPrice(), 0.0);
        verify(mockBun).getName();
        verify(mockBun).getPrice();
    }
}
