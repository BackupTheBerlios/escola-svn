/*
 * CadastrarPessoa.java
 *
 * Created on 25 de Julho de 2007, 11:06
 * Copyright paulo
 */
package exemploescola;

import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.Pessoa;
import br.ufg.inf.apsi.escola.componentes.pessoa.modelo.PessoaException;
import br.ufg.inf.apsi.escola.componentes.pessoa.servico.PessoaService;
import br.ufg.inf.apsi.escola.servicos.local.LocalServiceFactory;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Body;
import com.sun.rave.web.ui.component.Button;
import com.sun.rave.web.ui.component.Form;
import com.sun.rave.web.ui.component.Head;
import com.sun.rave.web.ui.component.Html;
import com.sun.rave.web.ui.component.ImageComponent;
import com.sun.rave.web.ui.component.Label;
import com.sun.rave.web.ui.component.Link;
import com.sun.rave.web.ui.component.Page;
import com.sun.rave.web.ui.component.TextField;
import javax.faces.FacesException;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CadastrarPessoa extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    
    private Page page1 = new Page();
    
    public Page getPage1() {
        return page1;
    }
    
    public void setPage1(Page p) {
        this.page1 = p;
    }
    
    private Html html1 = new Html();
    
    public Html getHtml1() {
        return html1;
    }
    
    public void setHtml1(Html h) {
        this.html1 = h;
    }
    
    private Head head1 = new Head();
    
    public Head getHead1() {
        return head1;
    }
    
    public void setHead1(Head h) {
        this.head1 = h;
    }
    
    private Link link1 = new Link();
    
    public Link getLink1() {
        return link1;
    }
    
    public void setLink1(Link l) {
        this.link1 = l;
    }
    
    private Body body1 = new Body();
    
    public Body getBody1() {
        return body1;
    }
    
    public void setBody1(Body b) {
        this.body1 = b;
    }
    
    private Form form1 = new Form();
    
    public Form getForm1() {
        return form1;
    }
    
    public void setForm1(Form f) {
        this.form1 = f;
    }
    
    private TextField txtNome = new TextField();
    
    public TextField getTxtNome() {
        return txtNome;
    }
    
    public void setTxtNome(TextField tf) {
        this.txtNome = tf;
    }
    
    private Label lblNome = new Label();
    
    public Label getLblNome() {
        return lblNome;
    }
    
    public void setLblNome(Label l) {
        this.lblNome = l;
    }
    
    private Button btnGravar = new Button();
    
    public Button getBtnGravar() {
        return btnGravar;
    }
    
    public void setBtnGravar(Button b) {
        this.btnGravar = b;
    }
    
    private Button btnVoltar = new Button();
    
    public Button getBtnVoltar() {
        return btnVoltar;
    }
    
    public void setBtnVoltar(Button b) {
        this.btnVoltar = b;
    }
    
    private Label lblCadastrarPessoa = new Label();
    
    public Label getLblCadastrarPessoa() {
        return lblCadastrarPessoa;
    }
    
    public void setLblCadastrarPessoa(Label l) {
        this.lblCadastrarPessoa = l;
    }
    
    // </editor-fold>
    
    private PessoaService pessoaService = null;
    private LocalServiceFactory localServiceFactory = null;

    private ImageComponent imgTopo1 = new ImageComponent();

    public ImageComponent getImgTopo1() {
        return imgTopo1;
    }

    public void setImgTopo1(ImageComponent ic) {
        this.imgTopo1 = ic;
    }

    private ImageComponent imgTopo2 = new ImageComponent();

    public ImageComponent getImgTopo2() {
        return imgTopo2;
    }

    public void setImgTopo2(ImageComponent ic) {
        this.imgTopo2 = ic;
    }

    private ImageComponent imgTopo4 = new ImageComponent();

    public ImageComponent getImgTopo4() {
        return imgTopo4;
    }

    public void setImgTopo4(ImageComponent ic) {
        this.imgTopo4 = ic;
    }

    private ImageComponent imgTopo3 = new ImageComponent();

    public ImageComponent getImgTopo3() {
        return imgTopo3;
    }

    public void setImgTopo3(ImageComponent ic) {
        this.imgTopo3 = ic;
    }

    private ImageComponent imgTopo5 = new ImageComponent();

    public ImageComponent getImgTopo5() {
        return imgTopo5;
    }

    public void setImgTopo5(ImageComponent ic) {
        this.imgTopo5 = ic;
    }
    
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CadastrarPessoa() {
        localServiceFactory = new LocalServiceFactory();
        pessoaService = localServiceFactory.obtemPessoaService();
    }
    
    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     *
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("CadastroPessoa Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }
    
    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    public void preprocess() {
    }
    
    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    public void prerender() {
    }
    
    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    public void destroy() {
    }
    
    public String btnVoltar_action() {
        // TODO: Processar o bot�o de a��o clicar. O valor de retorno � um nome de caso
        // de navega��o em que nulo far� retornar para a mesma p�gina.
        
        return "voltar";
    }
    
    public String btnGravar_action() {
        Pessoa pessoa = new Pessoa();
        
        try {
            pessoa.setNome(txtNome.getText().toString());
            pessoaService.gravar(pessoa);
        } catch(PessoaException e){
            e.printStackTrace();
        }
        txtNome.setText("");
        
        return null;
    }
}