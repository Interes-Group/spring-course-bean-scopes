package sk.stuba.fei.uim.asos.cvicenie1.beanscopes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.logging.Logger;

//@RestController
public class BeanScopesApplication {

    private static final Logger log = Logger.getLogger(BeanScopesApplication.class.getSimpleName());

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[]{"config.xml"});

        logBeanNames(appContext);

        Thread.sleep(500);

        logBeanNames(appContext);
    }

    private static void logBeanNames(ApplicationContext appContext) {
        SingletonBean singletonBean = appContext.getBean(SingletonBean.class);
        PrototypeBean prototypeBean = appContext.getBean(PrototypeBean.class);

        log.info(singletonBean.getName());
        log.info(prototypeBean.getName());
    }
//
//    @GetMapping("/")
//    public String getNames() throws InterruptedException {
//        SingletonBean singletonBean = appContext.getBean(SingletonBean.class);
//        PrototypeBean prototypeBean = appContext.getBean(PrototypeBean.class);
//        RequestBean requestBean = appContext.getBean(RequestBean.class);
//        SessionBean sessionBean = appContext.getBean(SessionBean.class);
//
//        StringBuilder builder = new StringBuilder();
//        builder.append(singletonBean.getName()).append("\n");
//        builder.append(prototypeBean.getName()).append("\n");
//        builder.append(requestBean.getName()).append("\n");
//        builder.append(sessionBean.getName()).append("\n");
//
//        Thread.sleep(500);
//        builder.append("\n----- After 500ms -----\n\n");
//
//        singletonBean = appContext.getBean(SingletonBean.class);
//        prototypeBean = appContext.getBean(PrototypeBean.class);
//        requestBean = appContext.getBean(RequestBean.class);
//
//        builder.append(singletonBean.getName()).append("\n");
//        builder.append(prototypeBean.getName()).append("\n");
//        builder.append(requestBean.getName()).append("\n");
//        builder.append(sessionBean.getName()).append("\n");
//
//        return builder.toString();
//    }
}