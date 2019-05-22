package com.example.efarmoghgiaodontiatrous;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Service;
import com.example.efarmoghgiaodontiatrous.domain.Visit;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.ServiceDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.VisitDAOMemory;

public class ViewStatisticsPresenter {
    ViewStatisticsView view;

    public ViewStatisticsPresenter(ViewStatisticsView view) {
        this.view = view;
    }

    public String onWelcome(String ID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        return "Welcome Dr. " + ddao.find(ID).getLastName() + "!\nBelow is the list with all the successful operations you have made:";
    }

    public String onStats(String ID) {
        DentistDAOMemory ddao = new DentistDAOMemory();
        VisitDAOMemory vdao = new VisitDAOMemory();
        ServiceDAOMemory sdao = new ServiceDAOMemory();
        Dentist dentist = ddao.find(ID);
        String result = "";
        int times;
        boolean has = false;
        for (Service serv : sdao.findAll()) {
            times = 0;
            for (Visit visit : vdao.findAll()) {
                if (dentist.equals(visit.getDentist()) && visit.getServices().contains(new Service(serv.getServiceName(), serv.getServiceID()))) {
                    has = true;
                    times++;
                }
            }
            if (times == 1) {
                result = result + serv.getServiceName() + ": " + times + " successful operation\n";
            } else if (times != 0) {
                result = result + serv.getServiceName() + ": " + times + " successful operations\n";
            }
        }
        if (!has) {
            result = "No successful operations yet!";
        }
        return result;
    }
}