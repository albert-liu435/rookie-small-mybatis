package com.rookie.middleware.mybatis.spring;

import cn.hutool.core.lang.ClassScanner;
import com.rookie.mybatis.session.SqlSessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.util.ClassUtils;

import java.util.Set;

/**
 * @Class MapperScannerConfigurer
 * @Description 扫描对象
 * @Author rookie
 * @Date 2024/4/25 18:02
 * @Version 1.0
 */
public class MapperScannerConfigurer implements BeanDefinitionRegistryPostProcessor {


    private String basePackage;

    private SqlSessionFactory sqlSessionFactory;





    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {


//        ClassPathBeanDefinitionScanner scanner=new ClassPathBeanDefinitionScanner(registry);
//
//         scanner.scan(basePackage);
//
//        for (String beanDefinitionName : scanner.getRegistry().getBeanDefinitionNames()) {
//
//            BeanDefinition beanDefinition = scanner.getRegistry().getBeanDefinition(beanDefinitionName);
//
//            beanDefinition.getPropertyValues().add("sqlSessionFactory", this.sqlSessionFactory);
//
//                // Bean 对象注册
//                registry.registerBeanDefinition(className, beanDefinition);
//        }


        try {




            Set<Class<?>> classes = ClassScanner.scanPackage(basePackage);
            for (Class<?> clazz : classes) {
//                String s = ClassUtils.convertClassNameToResourcePath(clazz.getSimpleName());
                SimpleMetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory();
                MetadataReader metadataReader = readerFactory.getMetadataReader(clazz.getName());
//
//
////
////
////
//////                definition.getPropertyValues().add("sqlSessionFactory", this.sqlSessionFactory);
////
//                SimpleMetadataReader reader=new SimpleMetadataReader("",Thread.currentThread().getContextClassLoader());
//                ClassMetadata classMetadata = reader.getClassMetadata();
//
//
//                reader.getClassMetadata()
////
////
////                String className = clazz.getSimpleName();
////
////                BeanDefinition definition = (BeanDefinition)metadataReader.getAnnotationMetadata();
//
//
//
//                definition.getPropertyValues().add("sqlSessionFactory", this.sqlSessionFactory);
//
//                // Bean 对象注册
//                registry.registerBeanDefinition(className, definition);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        // left intentionally blank

    }


    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

}

