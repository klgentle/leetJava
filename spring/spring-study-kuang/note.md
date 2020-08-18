

- @Autowired 
  可以直接在属性上使用,也可以在set方法上使用。
  在属性上使用后可以省略set方法，前提是在IOC容器中存在，且符合byName要求。

- @Resource默认通过byName的方式实现，如果失败，则通过byType方式

- @Component 说明这个类被Spring管理了