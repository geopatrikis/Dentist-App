package com.example.efarmoghgiaodontiatrous.view.Dentist.DentistViewProfile;

import com.example.efarmoghgiaodontiatrous.dao.DentistDAO;
import com.example.efarmoghgiaodontiatrous.dao.Initializer;
import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.memorydao.DentistDAOMemory;
import com.example.efarmoghgiaodontiatrous.memorydao.MemoryInitializer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DentistViewProfilePresenterTest {
    DentistViewProfilePresenter presenter;
    DentistViewProfileViewStub view;
    private DentistDAO dentistDao;

    @Before
    public void setUp() {
        Initializer initializer = new MemoryInitializer();
        initializer.prepareData();

        dentistDao = new DentistDAOMemory();

        view = new DentistViewProfileViewStub();
        presenter = new DentistViewProfilePresenter(view);
    }

    @Test
    public void onShowProfileTest() {
        Dentist d = dentistDao.find("6");
        Assert.assertEquals(presenter.onShowProfile("6"), "ID: " + d.getID() + "\n\nName: " + d.getLastName() + " " + d.getFirstName() + "\n\nE-mail: " + d.getEmail() + "\n\nPhone Number: " +
                d.getTelephoneNo() + "\n\nLicense Number: " + d.getExerciseLicense() + "\n\nUniversity: " + d.getUniversityAttended() +
                "\n\nLocation: " + d.getInfirmaryLocation().print() + "\n\nYears of Experience: " + d.getTimeOfExperience() +
                "\n\nServices: " + d.printServices() + "\n\nSpecializations: " + d.printSpecializations());

    }

    @Test
    public void onUpdateAccountTest() {
        presenter.onUpdateAccount();
    }
}