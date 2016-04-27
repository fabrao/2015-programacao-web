package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavigationRules {

    public String cadastrar(){
        return "logincadastro";
    }
    
    public String inserirPost(){
        return "home";
    }
    
    public NavigationRules() {
    }
    
}
