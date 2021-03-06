package servlet;

import com.sun.org.apache.xerces.internal.impl.xs.SchemaSymbols;
import entity.Score;
import entity.User;
import org.codehaus.jackson.map.ObjectMapper;
import util.shen.SqlOperation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shen on 2016/10/20.
 */
public class GetScore2 extends HttpServlet {
    private Connection conn;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Score> list;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        //首先获得用户的id
        User user = (User) session.getAttribute("user");
        int u_id = user.getId();
        int flag = 0;
        String rank2  = (String)request.getParameter("rank2");
        String period2 = (String)request.getParameter("period2");
        String begintime2 = (String)request.getParameter("begintime2");
        String endtime2 = (String)request.getParameter("endtime2");
        try {
            //下面将日期转换成毫秒
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Long begintime = sdf.parse(begintime2).getTime();
            Long endtime = sdf.parse(endtime2).getTime();
            Long period =  new Long(period2) * 24 * 3600*1000;
            SqlOperation sqlOperation = new SqlOperation();
            conn  = sqlOperation.initSqlOperation();
            long time = begintime + period;
            list = new ArrayList<Score>();
            while(time < endtime){
                System.out.println(flag +"  "+ time + " "+ endtime);
                flag++;
                String sql = "SELECT SUM(score) score FROM record WHERE  r_time >= ? AND r_time <= ? AND r_rank = ? AND u_id = ? GROUP BY r_num";
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setLong(1,begintime);
                preparedStatement.setLong(2,time);
                preparedStatement.setString(3,rank2);
                preparedStatement.setInt(4,u_id);
                System.out.println(preparedStatement);
                resultSet = preparedStatement.executeQuery();
                int count = 0;
                int sum = 0;
                while (resultSet.next()){
                    count++;
                    sum = resultSet.getInt("score")+sum;
                }
                begintime = time;
                time = begintime + period;
                if(count != 0){
                    System.out.println(flag);
                    Score score = new Score((flag * new Integer(period2))+"",(sum /count)+"");
                    list.add(score);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String result = objectMapper.writeValueAsString(list);
        System.out.println(result);
       // request.setAttribute("result",result);
        response.getWriter().print(result);
        System.out.println("bbbbb");
    }
}
