package validating.input;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

/**
 * created by Atiye Mousavi
 * Date: 8/27/2021
 * Time: 5:00 PM
 */
@Controller
public class WebController implements WebMvcConfigurer {//اینWebMvcConfigurer  برای فعال سازی @EnableWebMvc این است
    //@EnableWebMvc به صورت خودکار توسط SpringBootApplication@ فعال میشود

    //متد addArgumentResolvers برای اضافه کردن resolver برای ساپورت کردن انواع آرگمان های کنترل کننده
    //متد addCrosMapping برای کانفیگ cross origin کلی برای request ها است
    //متد addFormatters برای اضافه کردن formatter است
    //متد addInterceptors برای اضافه کردن یک interceptor برای عملیات pre و post برای کنترل متد ها فراخوانی شده request ها
    //متد addResourceHandlers برای اضافه کردن یک سری از منابع استاتیک مانند فایل های cs js و..7
    //متدaddReturnValueHandlers برای اضافه کردن یک custom return value handler است
    // متد addViewControllers برای response status code و renderکردن صفحه Response body است
    //متد configureAsyncSupport برای config کردن asynchronous request است
    //متدconfigureContentNegotiationبرای کانفیگ کردن negotiation  است
    //متد configureDefaultServletHandling برای کانفیگ کردن یک handler برای درخواست handle نشده و انتقال آن ها به servlet پیش فرض
    //متد configureHandlerExceptionResolv برای کانفیگ کردن یک exception resolver
    //متد configureMessageConverters برای کانفیگ کردن HttpMessageConverter است برای خواندن اطلاعات از request و نوشتن اطلاعات  در response body
    //متد configurePathMatch برای کانفیگ کردن pathMatch است
    //متدconfigureViewResolvers برای گرفتن یک نام string و render کردن controller مربوطه است
    //متد extendHandlerExceptionResolvers برای ارث بری و یا تغییر لیست exception بصورت پیش فرض استفاده میشود
    //متدextendMessageConverters پس از تنظیم ، یا پیکربندی یا راه اندازی اولیه با یک لیست پیش فرض ، لیست  ارث برده  یا اصلاح کنید.
    //متد getMessageCodesResolver برای تولید یک custom messageCodesResolver از data binding و validation error است
    //متد getValidator برای تولید بک custom validator به جای  validatorدیفالت است
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }
    @GetMapping("/")
    public String showForm(PersonForm personForm){
        return "form";//این داره template به اسم from را برمیگرداند.
    }
    @PostMapping
    //@Valid هایی که در کلاس گذاشتیم براش اعمال میشه
    //BindingResult برای این است که چک کنیم آیا خطایی در PersomForm اتفاق افتاده یا خیر
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "form";
        }
        return "redirect:/results";
    }
}
