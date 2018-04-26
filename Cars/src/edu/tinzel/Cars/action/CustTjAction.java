package edu.tinzel.Cars.action;

import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.ActionSupport;

import edu.tinzel.Cars.biz.TjBiz;
import edu.tinzel.Cars.biz.impl.TjBizImpl;
import edu.tinzel.Cars.entity.CustTj;
import edu.tinzel.Cars.util.BaseAction;

public class CustTjAction extends ActionSupport {
	TjBiz tjBiz=new TjBizImpl();
	public  String   createChart(){
		
		
		return SUCCESS;
	}
	private JFreeChart chart;
	// 必须提供getChart()方法，且由该方法返回JFreeChart对象
	public JFreeChart getChart()
	{
		 
		chart = ChartFactory.createPieChart3D(
				"客户统计图",  // 图表标题
				getDataSet(), //数据
				true, // 是否显示图例
				false, //是否显示工具提示
				false //是否生成URL
	      );
		// 重新设置图表标题，改变字体
		chart.setTitle(new TextTitle("客户统计图"
			, new Font("黑体", Font.ITALIC , 22)));
		// 取得统计图表的第一个图例
		LegendTitle legend = chart.getLegend(0);
		// 修改图例的字体
		legend.setItemFont(new Font("宋体", Font.BOLD, 14));
		// 获得饼图的Plot对象
		PiePlot plot = (PiePlot)chart.getPlot();
		// 设置饼图各部分的标签字体
		plot.setLabelFont(new Font("黑体", Font.BOLD, 18));
		// 设定背景透明度（0-1.0之间）
        plot.setBackgroundAlpha(0.9f);
		// 设定前景透明度（0-1.0之间）
        plot.setForegroundAlpha(0.50f);
        //使用百分比显示
        plot.setLabelGenerator(new StandardPieSectionLabelGenerator("{2}"));
		return chart;
	}
	// 获取生成统计图的Dataset
	private DefaultPieDataset getDataSet()
	{
		// 提供生成饼图的数据
		DefaultPieDataset dataset = new DefaultPieDataset();
		try {
			
			List<CustTj> list=tjBiz.queryAll();
			for(CustTj ctj:list){
				//设置每块区域的名称及所占比例
				dataset.setValue(ctj.getCustomerAdd(),ctj.getCount() );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dataset;
	}

}
