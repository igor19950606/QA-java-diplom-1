package praktikum;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BunTest {

    private Bun bun;

    @Before
    public void setUp() {
        // Стаб данных для булочки
        bun = new Bun("Булочка", 35);
    }

    @Test
    public void testBunConstructor() {
        // Проверяем правильную инициализацию полей
        assertEquals("Булочка", bun.getName());
        assertEquals(35, bun.getPrice(), 0.0);
    }

    @Test
    public void testGetName() {
        // Проверяем метод получения имени
        assertEquals("Булочка", bun.getName());
    }

    @Test
    public void testGetPrice() {
        // Проверяем метод получения цены
        assertEquals(35, bun.getPrice(), 0.0);
    }

    // Используем моки для теста взаимодействия класса с другими объектами
    @Test
    public void testWithMock() {
        // Создаем мок объекта Bun
        Bun mockBun = mock(Bun.class);

        // Настраиваем его поведение
        when(mockBun.getName()).thenReturn("Имитация");
        when(mockBun.getPrice()).thenReturn(3.5F);

        // Проверяем взаимодействие
        assertEquals("Имитация", mockBun.getName());
        assertEquals(3.5, mockBun.getPrice(), 0.0);

        // Убедимся, что методы вызваны
        verify(mockBun).getName();
        verify(mockBun).getPrice();
    }
}
