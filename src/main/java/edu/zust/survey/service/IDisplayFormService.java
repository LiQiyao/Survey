package edu.zust.survey.service;

import edu.zust.survey.entity.DisplayForm;
import edu.zust.survey.vo.GradeChoiceVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Lee on 2017/11/15.
 */
public interface IDisplayFormService {

    boolean modifyDisplayForm(Integer majorId, HttpServletRequest request);

    List<DisplayForm> getDisplayFormsByMajorId(Integer majorId);

    boolean synchronizeDisplayForm();

    List<GradeChoiceVo> assembleGradeChoiceVos(Integer majorId);
}
