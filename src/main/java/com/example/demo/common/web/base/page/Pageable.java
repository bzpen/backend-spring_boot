package com.example.demo.common.web.base.page;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 分页工具
 *
 * @author kaito kuroba
 * @date 2021/12/6
 */
public class Pageable {

    /**
     * 私有构造
     */
    private Pageable(){ }

    /**
     * 内存分页
     * @param records    待分页数据
     * @param pageIndex   当前页码
     * @param pageSize    每页显示条数
     * @return
     */
    public static <T> List<T> of(List<T> records, int pageIndex,int pageSize){
        if(records == null ){
            return Collections.emptyList();
        }
        int totalCount = records.size();
        int remainder = totalCount % pageSize;
        int pageCount = (remainder>0)?totalCount/pageSize + 1 : totalCount/pageSize;
        if(remainder == 0){
            return records.stream().skip((pageIndex - 1)*pageSize).limit(pageSize).collect(Collectors.toList());
        }else{
            if(pageIndex == pageCount){
                return records.stream().skip((pageIndex-1)*pageSize).limit(totalCount).collect(Collectors.toList());
            }else{
                return records.stream().skip((pageIndex - 1) * pageSize).limit(pageSize).collect(Collectors.toList());
            }
        }
    }

    /**
     * 内存分页
     *
     * @param request
     * @param records
     * @param <T>
     * @return
     */
    public static <T> PageResponse<T> of(PageRequest request,List<T> records){
        return new PageResponse<T>(records.size(),
                of(
                        records,
                        request.getPageNum(),
                        request.getPageSize()
                ));
    }

    /**
     * 物理分页
     *
     * @param request
     * @param record
     * @param <T>
     * @return
     */
    public static <T> PageResponse<T> of(PageRequest request,Record record){
        PageHelper.startPage(request.getPageNum(),request.getPageSize());
        return new PageResponse<>(new PageInfo<>(record.invoke()));
    }

    /**
     * 内部类
     *
     * 常用于分页数据的来源实现
     * */
    public interface Record<T> {

        List<T> invoke();
    }
}
