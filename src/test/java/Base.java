import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class Base {

    @Inject
    protected WebDriver driver;

    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driver, this);
    }

}
