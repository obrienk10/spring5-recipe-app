package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repository.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(SpringJUnit4ClassRunner.class)
public class RecipeServiceImplTest {

//    @InjectMocks
    RecipeServiceImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        Set<Recipe> expectedRecipes = new HashSet<>();
        expectedRecipes.add(recipe);

        when(recipeRepository.findAll()).thenReturn(expectedRecipes);

        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
    }
}