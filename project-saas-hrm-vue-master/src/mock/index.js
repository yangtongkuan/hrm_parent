import Mock from 'mockjs'
import TableAPI from './table'
import ProfileAPI from './profile'
import LoginAPI from './login'
import companyAPI from './company'

Mock.setup({
  // timeout: '1000'
})

Mock.mock(/\/table\/list\.*/, 'get', TableAPI.list)
Mock.mock(/\/frame\/profile/, 'post', ProfileAPI.profile)
Mock.mock(/\/frame\/login/, 'post', LoginAPI.login)
// 配置企业模拟数据
Mock.mock(/\/company/, 'get', companyAPI.list) // 访问企业列表
Mock.mock(/\/company\/.*/, 'get', companyAPI.sassDetail) // 访问企业详情
