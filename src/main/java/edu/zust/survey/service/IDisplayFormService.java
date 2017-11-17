package edu.zust.survey.service;

import edu.zust.survey.entity.DisplayForm;

import java.util.List;

/**
 * Created by Lee on 2017/11/15.
 */
public interface IDisplayFormService {

    boolean modifyDisplayForm(Integer displayFormId, boolean[] partIsShow);

    List<DisplayForm> getDisplayFormByMajorId(Integer majorId);

    boolean synchronizeDisplayForm();
}
