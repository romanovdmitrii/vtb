package ru.dmitriiromanov.lessons.spring.less1.camera;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class UnproducableCameraRollBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        // Получаем имена всех BeanDefinition для доступа к каждому из них
        String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();
        // Перебираем все имена
        for (String name : beanDefinitionNames) {
            // Получаем BeanDefinition по имени
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(name);
            //Получаем имя класса создаваемого бина, чтобы проверить, * содержит ли он аннотацию UnproducableCameraRoll
            String className = beanDefinition.getBeanClassName();
            try {
                // Получаем класс по имени
                if (StringUtils.isNotBlank(className)) {
                    Class<?> beanClass = Class.forName(className);
                    /*Пытаемся получить объект аннотации и ее значение,
                     * если  класс не содержит данную аннотацию, то  метод вернет null
                     */
                    UnproducableCameraRoll annotation = (UnproducableCameraRoll) beanClass.getAnnotation(UnproducableCameraRoll.class);
                    // Проверяем, содержал ли класс эту аннотацию
                    if (annotation != null) {
                        // Получаем значение, указанное в параметрах аннотации (класс пленки, которую необходимо использовать)
                        Class usingCameraRollName = annotation.usingCameraRollClass();
                        // Меняем класс будущего бина
                        beanDefinition.setBeanClassName(usingCameraRollName.getName());
                    }
                }

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
