package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.model.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CategoryCommandToCategoryTest {

    private final Long LONG_VALUE = 1L;
    private final String DESCRIPTION = "description";
    private CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        this.converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void testConvert() {
        CategoryCommand categoryCommand = new CategoryCommand();
        categoryCommand.setId(LONG_VALUE);
        categoryCommand.setDescription(DESCRIPTION);

        Category actual = converter.convert(categoryCommand);

        assertNotNull(actual);
        assertEquals(LONG_VALUE, actual.getId());
        assertEquals(DESCRIPTION, actual.getDescription());
    }
}
