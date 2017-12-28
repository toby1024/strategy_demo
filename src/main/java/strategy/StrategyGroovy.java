package strategy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

import java.util.Map;

public class StrategyGroovy implements IStrategy {
    public Map doSomething(int distance) {
        Binding binding = new Binding();
        GroovyShell shell = new GroovyShell(binding);
        Script script = shell.parse("def calculate(distance) {" +
                "  fee  = 0;" +
                "  if(distance <= 120){" +
                "    distance = 120; " +
                "    fee = 48;" +
                "  }else if(distance > 120 && distance <=220){" +
                "    fee = distance * 0.4d;" +
                "  }else if(distance > 220 && distance <=780){" +
                "    fee = 220 * 0.4d + (distance-220)*0.2d;" +
                "  }else if(distance > 780 && distance <3000){" +
                "    distance = 780" +
                "    fee = 200" +
                "  }else if(distance > 3000){" +
                "    distance = 3000" +
                "    fee = 249" +
                "  };" +
                "  return [distance: distance, fee: fee];" +
                "}");
        System.out.println("this is strategy groovy");
        return (Map) script.invokeMethod("calculate", new Object[]{distance});
    }
}

//    Proc.new { |car_bind_info_id, distance, change_time|
//            car_bind_info = CarBindInfo.find(car_bind_info_id)
//        cnt   = BatteryChangeRecord.count_by_car_id(CarBindInfo.find(car_bind_info_id).car_id)
//
//        fee   =if distance <= 120
//        distance = 120
//        48
//        elsif distance > 120 && distance <= 220
//        distance.to_d * "0.4".to_d
//        elsif distance > 220 && distance <= 780
//        "220".to_d * "0.4".to_d + (distance.to_d - "220".to_d) * "0.2".to_d
//        elsif distance > 780 && distance < 3000
//        distance = 780
//        200
//        elsif distance >= 3000
//        distance = 3000
//        249
//        end
//
//                expend_fee_gift = 0
//        company_account = car_bind_info.payer.company_account
//        balance         = company_account.balance.to_d - fee.to_d
//        enough_balance = car_bind_info.payer.charge == 1 ? true : company_account.balance >= fee
//        {
//            pooled_fee:      format("%.2f", fee).to_f,
//                    fee:             0,
//                enough_balance:  enough_balance,
//                balance:         format("%.2f", balance).to_f,
//                fee_distance:    fee_distance ||= distance,
//                free_distance:   0,
//                change_count:    "000000#{cnt}".last(6),
//                expend_fee_gift: format("%.2f", expend_fee_gift).to_f
//        }
//    }