package org.b3log.symphony.spring.stock;


import org.b3log.symphony.spring.service.python.ExecPythonCodeService;
import org.b3log.symphony.spring.service.python.ExecuteCmd;
import org.b3log.symphony.spring.stock.network.DetailStock;
import org.b3log.symphony.spring.stock.sinamodel.CurrentStockModelReal;
import org.b3log.symphony.spring.stock.sinamodel.HistroyStockModel;
import org.b3log.symphony.spring.stock.sinamodel.HistroyStockParams;
import org.b3log.symphony.spring.stock.sinamodel.SinaConstantURL;
import org.b3log.symphony.spring.util.DesUtil;
import org.python.core.PyException;
import org.python.util.PythonInterpreter;

import java.io.*;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class App {

    public static final int getProcessID() {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        System.out.println(runtimeMXBean.getName());
        return Integer.valueOf(runtimeMXBean.getName().split("@")[0])
                .intValue();
    }

    public static void main(String[] args) throws IOException, PyException {

        System.out.println(getProcessID());

        String abc = String.valueOf(Integer.MAX_VALUE);
        System.out.println(abc);

        int i=3,j;
        outter:while(i>0){
            j=3;
            inner:while(j>0){
                if(j<2) break outter;
                System.out.println(i+"and"+j);
                j--;
            }
            i--;
        }

        label1 :
        {
            System.out.print("ab1");
            if (1 == 1) {
                break label1;
            }
        }
        label2 : System.out.print("ab2");
        label3 : System.out.print("ab3");


        try {
            FutureTask<String> ft = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "asfdasfdasdf hahah";
                }
            });
            new Thread(ft).start();
            System.out.println(ft.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Properties props = new Properties();
        props.put("python.console.encoding", "UTF-8");
        props.put("python.security.respectJavaAccessibility", "false");
        props.put("python.import.site", "false");
        Properties preprops = System.getProperties();
        PythonInterpreter.initialize(preprops, props, new String[0]);

//        PythonInterpreter interpreter = new PythonInterpreter();
//        //执行Python语句
//        interpreter.exec(Py.newStringUTF8("import sys"));
//        interpreter.exec(Py.newStringUTF8("print 'python'"));
//        interpreter.exec(Py.newStringUTF8("print 'jython 执行器;'"));


//        ExecPythonCodeService.execPythonCodeForLine("import sys");
//        ExecPythonCodeService.execPythonCodeForLine("print 'python'");
//        ExecPythonCodeService.execPythonCodeForLine("print 'jython 执行器;'");

        String tt = "import sys\n" +
                "print 'python'\n" +
                "print 'jython 执行器'";
        File file = new File("2");

        FileOutputStream writer = new FileOutputStream(file);
        writer.write(tt.getBytes("UTF-8"));
        writer.flush();

        String[] aa={"python",file.getAbsolutePath()};

        String cc = ExecuteCmd.execute(aa,"UTF-8");

        ExecPythonCodeService service = new ExecPythonCodeService();
        System.out.print(service.execPythonCodeForLine("import sys"));
        System.out.print(service.execPythonCodeForLine("print 'python'"));
        System.out.print(service.execPythonCodeForLine("print 'jython 执行器'"));

        String g="123";
        String h= DesUtil.encryptBasedDes(g);
        System.out.println(h);
        System.out.println(DesUtil.decryptBasedDes(h));

        HistroyStockParams histroyStockParams = new HistroyStockParams();
        histroyStockParams.setDatalen(1023);
        histroyStockParams.setMa("5");
        histroyStockParams.setSymbol("sz000001");
        histroyStockParams.setScale("5");
        System.out.println(histroyStockParams.toUrlString());

        String ccc = DetailStock.get(SinaConstantURL.HISTORY_STOCK + histroyStockParams.toUrlString());

        List<HistroyStockModel> historyStockModels = HistroyStockModel.parseStockData(ccc);

        for (HistroyStockModel currentStockModel : historyStockModels ){
            System.out.println("结果：" + currentStockModel.toString());
        }










        String aaa = DetailStock.get(DetailStock.SHANGZHENG_STOCK_PREFIX +
                "sh600001"
                + ",sh600002"
                + ",sh600003"
                + ",sh600004"
                + ",sh600005"
                + ",sh600006"
                + ",sh600007"
                + ",sz000681"
                + ",sz000682"
                + ",sz000683"
                + ",sz000684"
                + ",sz000685"
                + ",sz000686"
        );
        String bbb = aaa;

        List<CurrentStockModelReal> list =  CurrentStockModelReal.parseStockData(aaa);
        for (CurrentStockModelReal currentStockModel : list ){
            System.out.println("结果：" + currentStockModel.toString());
        }
    }

}
