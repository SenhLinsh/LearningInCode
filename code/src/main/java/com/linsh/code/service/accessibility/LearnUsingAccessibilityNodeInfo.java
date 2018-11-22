package com.linsh.code.service.accessibility;

import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;

import com.linsh.code._.Getter;

/**
 * <pre>
 *    author : Senh Linsh
 *    github : https://github.com/SenhLinsh
 *    date   : 2018/02/02
 *    desc   : 该类代表一个窗口内容节点和可以从源请求的操作。
 *             从 AccessibilityService的角度看，一个窗口内容被呈现为一个无障碍节点信息树，该树可能与视图层次一一映射，也可能不与视图
 *             层次一一映射。换句话说，一个自定义视图可灵活地将自己报告为一个无障碍节点信息树。一旦无障碍节点信息被发送给无障碍服务，该
 *             信息将会是不可改变的，且调用状态改变方法将会产生错误。AccessibilityNodeInfo文档 Zh :
 *             http://www.siaa.org.cn/home/content/sharedetail/aid/1144
 *
 * </pre>
 */
public class LearnUsingAccessibilityNodeInfo {

    public static void demo(AccessibilityNodeInfo info) {
        //================================================ 常量 ================================================//
        int action, focus, movement;
        String argument;
        action = AccessibilityNodeInfo.ACTION_ACCESSIBILITY_FOCUS; // 给节点添加无障碍焦点的操作。
        action = AccessibilityNodeInfo.ACTION_CLEAR_ACCESSIBILITY_FOCUS; // 清除节点无障碍焦点的操作。
        action = AccessibilityNodeInfo.ACTION_CLEAR_FOCUS; // 清除节点输入焦点的操作。
        action = AccessibilityNodeInfo.ACTION_CLEAR_SELECTION; // 取消选择节点的操作。
        action = AccessibilityNodeInfo.ACTION_NEXT_AT_MOVEMENT_GRANULARITY; // 以给定移动粒度，请求去到该节点文本的下一个文本实体的操作。
        action = AccessibilityNodeInfo.ACTION_CLICK; // 在节点信息上点击的操作.
        action = AccessibilityNodeInfo.ACTION_COLLAPSE; // 折叠一个可展开节点的操作。
        action = AccessibilityNodeInfo.ACTION_COPY; // 将当前选择拷贝到剪贴板的操作。
        action = AccessibilityNodeInfo.ACTION_CUT; // 剪贴当前选项并放置到剪贴板的操作。
        action = AccessibilityNodeInfo.ACTION_DISMISS; // 关闭一个可关闭节点的操作。
        action = AccessibilityNodeInfo.ACTION_EXPAND; // 展开一个可展开节点的操作。
        action = AccessibilityNodeInfo.ACTION_FOCUS; // 给节点添加输入焦点的操作。
        action = AccessibilityNodeInfo.ACTION_LONG_CLICK; // 在节点上点击长按的操作。
        action = AccessibilityNodeInfo.ACTION_NEXT_HTML_ELEMENT; // 移动到给定类型的下一个 HTML 元素的操作。例如，移动到 BUTTON、INPUT、TABLE 等。
        action = AccessibilityNodeInfo.ACTION_PASTE; // 粘贴当前剪贴板内容的操作。
        action = AccessibilityNodeInfo.ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY; // 以给定移动粒度，请求去到该节点文本的上一个文本实体的操作。例如，移动到下一个字、词等。
        action = AccessibilityNodeInfo.ACTION_PREVIOUS_HTML_ELEMENT; // 移动到给定类型的上一个 HTML 元素的操作。例如，移动到BUTTON、INPUT、TABLE 等。
        action = AccessibilityNodeInfo.ACTION_SCROLL_BACKWARD; // 向后滚动节点内容的操作。
        action = AccessibilityNodeInfo.ACTION_SCROLL_FORWARD; // 向前滚动节点内容的操作
        action = AccessibilityNodeInfo.ACTION_SELECT; // 选择节点的操作。
        action = AccessibilityNodeInfo.ACTION_SET_SELECTION; // 设置选择项的操作。执行该操作，并且无参数清除选项
        action = AccessibilityNodeInfo.ACTION_SET_TEXT; // 设置节点文本的操作。在没有参数的情况下执行该操作，使用 null 或者空CharSequence 将会清除文本。该操作也将会把光标放置到文本末尾
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_COLUMN_INT; // 让指定集合列在屏幕上可见的参数。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN; // 当以一定粒度移动时，是否扩大选择范围或反之移除的参数。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_HTML_ELEMENT_STRING; // 要移动到的下一个/上一个 HTML 元素的参数。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT; // 当遍历节点文本的时，使用哪种移动粒度的参数。。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_PROGRESS_VALUE; // 指定要设置的进度值的参数。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_ROW_INT; // 让指定集合行在屏幕上可见的参数。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_END_INT; // 指定选择结束的参数。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_SELECTION_START_INT; // 指定选择起始的参数。
        argument = AccessibilityNodeInfo.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE; // 指定要设置的文本内容的参数。
        focus = AccessibilityNodeInfo.FOCUS_ACCESSIBILITY; // 无障碍焦点。
        focus = AccessibilityNodeInfo.FOCUS_INPUT; // 输入焦点。
        movement = AccessibilityNodeInfo.MOVEMENT_GRANULARITY_CHARACTER; // 以字符为移动粒度位，遍历节点文本
        movement = AccessibilityNodeInfo.MOVEMENT_GRANULARITY_LINE; // 以行为移动粒度位，遍历节点文本。
        movement = AccessibilityNodeInfo.MOVEMENT_GRANULARITY_PAGE; // 以页为移动粒度位，遍历节点文本。
        movement = AccessibilityNodeInfo.MOVEMENT_GRANULARITY_PARAGRAPH; // 以段为移动粒度位，遍历节点文本。
        movement = AccessibilityNodeInfo.MOVEMENT_GRANULARITY_WORD; // 以字词为移动粒度位，遍历节点文本。

        //================================================ API 20 ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            info.addAction(Getter._int); // 为一个nodeInfo添加一个操作，在API 21时被弃用
            info.addAction(Getter._int); // 为一个nodeInfo添加一个操作，API 21
            info.addChild(Getter.view, Getter._int); // 添加一个虚拟子元素，作为给定根节点的子view
            info.addChild(Getter.view); // 添加一个子view节点。
            info.canOpenPopup(); // 获取该节点是否可以打开一个弹窗或对话框。
            info.describeContents(); // 描述被包含在可打包实例的封装代表中的特殊对象的种类。
            info.findAccessibilityNodeInfosByText(Getter.text); // 使用文本找到 AccessibilityNodeInfo。
            info.findAccessibilityNodeInfosByViewId(Getter.text); // 使用完全合格视图id的源名称找到AccessibilityNodeInfo，完全合格 id 的样式 如下“package:id/id_resource_name”。
            info.findFocus(Getter._int); // 找到具有指定焦点类型的视图。
            info.focusSearch(Getter._int); // 在指定方向搜索具有输入焦点的最近的视图。
            info.getActions(); // 该方法在 API 级别 21 被弃用。使用getActionList()代替。
            info.getBoundsInParent(Getter.rect); // 获取父级坐标中的节点边界。
            info.getBoundsInScreen(Getter.rect); // 获取屏幕坐标中的节点边界。
            info.getChild(Getter._int); // 获取给定索引下的子元素。
            info.getChildCount(); // 获取子元素的数目。
            info.getClassName(); // 获取该节点来自的类。
            info.getCollectionInfo(); // 如果节点是个集合，获取集合信息。一个集合子集总是一个集合项目。
            info.getCollectionItemInfo(); // 如果节点是个集合项目，获取集合项目信息。一个集合项目总是一个集合的子集。
            info.getContentDescription(); // 获取该节点的内容描述。
            info.getExtras(); // 获取具有附加数据的可选 bundle。该包是闲时创建的且永不为 null。注意：为了避免冲突，推荐使用应用的包名作为关键字字首，如果从不同应用发出的相同关键词有不同的含义，可能会导致无障碍服务困扰。
            info.getInputType(); // 获取定义为 InputType 的源中的输入类型。
            info.getLabelFor(); // 为无障碍目的，获取作为标签代表该视图的节点信息。 返回AccessibilityNodeInfo
            info.getLabeledBy(); // 为无障碍目的，获取作为标签代表该视图的节点信息。返回AccessibilityNodeInfo
            info.getLiveRegion(); // 获取该节点的实时区域模式。一个实时区域是一个包含对用户来说重要信息的节点，且当其改变时应该告知用户。例如，在一个登录界面，有一个呈现“密码错误”通知的 TextView，该视图应该使用ACCESSIBILITY_LIVE_REGION_POLITE模式被标记为一个实时区域。这是无障碍服务的责任，控制TYPE_WINDOW_CONTENT_CHANGED 事件标识实时区域节点和其子元素的变化。实时区域模式，或如果视图不是个实时区域，返回ACCESSIBILITY_LIVE_REGION_NONE。
            info.getMovementGranularities(); // 获取遍历该节点文本的移动粒度。
            info.getPackageName(); // 获取该节点来自的包名。
            info.getParent(); // 获取父级NodeInfo。
            info.getRangeInfo(); // 如果节点是个范围，获取范围信息AccessibilityNodeInfo.RangeInfo
            info.getText(); // 获取该节点的文本。
            info.getTextSelectionEnd(); // 选择文本的末尾，如果没有选择文本，返回光标位置，或如果不存在选择文本和光标，返回-1。
            info.getTextSelectionStart(); // 选择文本的起始，如果没有选择文本，返回光标位置，或如果不存在选择文本和光标，返回-1。
            info.getViewIdResourceName(); // 获取源视图 id 的完全合格源名称。
            info.getWindowId(); // 获取该信息来自的窗口的id。
            info.hashCode(); // 返回该对象的哈希编码值。多用于判断node是否相同
            info.isAccessibilityFocused(); // 获取该节点是否可被无障碍聚焦。
            info.isCheckable(); // 获取该节点是否可选中。
            info.isChecked(); // 获取该节点是否已选中。
            info.isClickable(); // 获取该节点是否可点击。
            info.isContentInvalid(); // 获取该节点的内容是否已失效。例如，一个日期数据格式不正确。
            info.isDismissable(); // 获取该节点是否可被关闭。
            info.isEditable(); // 获取该节点是否可编辑。
            info.isEnabled(); // 获取该节点是否可用。
            info.isFocusable(); // 获取该节点是否可获取焦点。
            info.isFocused(); // 获取该节点是否已被聚焦。
            info.isLongClickable(); // 获取该节点是否可长按点击。
            info.isMultiLine(); // 获取该节点是否是个多行可编辑文本。
            info.isPassword(); // 获取该节点是否是个密码。
            info.isScrollable(); // 获取该节点是否可滚动。
            info.isSelected(); // 获取该节点是否已被选择。
            info.isVisibleToUser(); // 该节点是否对用户可见。
            info.obtain(Getter.view, Getter._int); // 如果可获得，返回一个缓存实例，否则创建一个新的并设置源。 View:虚拟子树的根。  int:虚拟后代的id。返回一个实例化的AccessibilityNodeInfo
            info.obtain(Getter.accessibilitynodeinfo); // 如果可获得，返回一个缓存实例，或创建一个新的。返回的实例初始化自一个给定 root。
            info.obtain(); // 如果可获得，返回一个缓存实例，否则，返回一个新的。
            info.obtain(Getter.view); // 如果可获得，返回一个缓存实例，否则，返回一个新的并设置源。View：源视图。
            info.performAction(Getter._int, Getter.bundle); // 在该节点上执行一个操作。int: 要执行的操作。Bundle：具有额外参数的包。返回一个布尔值，表示是否成功执行操作。
            info.performAction(Getter._int); // 在该节点上执行一个操作。
            info.recycle(); // 返回一个实例重复使用，回收掉当前的实例。
            info.refresh(); // 刷新视图呈现的最新状态信息。返回一个布尔值，表示是否刷新成功。
            info.setAccessibilityFocused(Getter._boolean); // 设置该节点可无障碍聚焦。
            info.setBoundsInParent(Getter.rect); // 在父级坐标中设置节点边界。
            info.setBoundsInScreen(Getter.rect); // 在屏幕坐标中设置节点边界。
            info.setCanOpenPopup(Getter._boolean); // 设置该节点可打开一个弹窗或对话框。
            info.setCheckable(Getter._boolean); // 设置该节点可选中。
            info.setChecked(Getter._boolean); // 设置该节点已选中。
            info.setClassName(Getter.text); // 设置该节点来自的类。
            info.setClickable(Getter._boolean); // 设置该节点可点击。
            info.setCollectionInfo(Getter.collectionInfo); // 如果该节点是个集合，设置集合信息。一个集合子集通常也是个集合项目。
            info.setContentDescription(Getter.text); // 设置该节点的内容描述。
            info.setContentInvalid(Getter._boolean); // 设置节点内容无效。例如，一个日期数据格式不正确。
            info.setDismissable(Getter._boolean); // 设置该节点可以被关闭。
            info.setEditable(Getter._boolean); // 设置该节点可编辑。
            info.setEnabled(Getter._boolean); // 设置该节点可用。
            info.setFocusable(Getter._boolean); // 设置该节点可聚焦。
            info.setFocused(Getter._boolean); // 设置该节点已聚焦。
            info.setInputType(Getter._int); // 设置源中的输入类型为inputType
            info.setLabelFor(Getter.view, Getter._int); // 为无障碍目的，设置可作为标签代表视图的信息。如果 virtualDescendantId 为NO_ID，根被设置为标签。一个虚拟后代是一个虚构视图，为无障碍目的，将自己报告为视图层次的一部分。该操作可以使绘制复杂内容的自定义视图，将自己报告为虚拟视图树，然后传递其逻辑结构。
            info.setLabelFor(Getter.view); // 为无障碍目的，设置可作为标签代表视图的信息。
            info.setLabeledBy(Getter.view); // 为无障碍目的，设置可作为标签代表视图的信息。
            info.setLabeledBy(Getter.view, Getter._int); // 为无障碍目的，设置可作为标签代表视图的信息。如果 virtualDescendantId 为NO_ID，根被设置为标签。一个虚拟后代是一个虚构视图，为无障碍目的，将自己报告为视图层次的一部分。该操作可以使绘制复杂内容的自定义视图，将自己报告为虚拟视图树，然后传递其逻辑结构。
            info.setLiveRegion(Getter._int); // 设置该节点的实时区域模式。int：实时区域模式，或如果视图不是个实时区域时，为ACCESSIBILITY_LIVE_REGION_NONE。
            info.setLongClickable(Getter._boolean); // 设置该节点可长按点击。
            info.getMovementGranularities(); // 设置遍历节点文本的移动粒度。
            info.setMultiLine(Getter._boolean); // 设置该节点为一个多行可编辑文本。
            info.setPackageName(Getter.text); // 设置该节点来自的包。
            info.setParent(Getter.view, Getter._int); // 设置给定 root 虚拟后代的父元素。如果 virtualDescendantId 等于 NO_ID，该root 被设置为父级。一个虚拟后代是一个虚构视图，为无障碍目的，将自己报告为视图层次的一部分。该操作可以使绘制复杂内容的自定义视图，将自己报告为虚拟视图树，然后传递其逻辑结构。
            info.setParent(Getter.view); // 设置父元素。
            info.setPassword(Getter._boolean); // 设置该节点为密码。
            info.setRangeInfo(Getter.rangeInfo); // 如果该节点是个范围，设置范围信息。
            info.setScrollable(Getter._boolean); // 设置该节点可滚动。
            info.setSelected(Getter._boolean); // 设置该节点是否已选择。
            info.setSource(Getter.view); // 设置信息源。
            info.setSource(Getter.view, Getter._int); // 为给定 root 虚拟后代设置源。如果 virtualDescendantId 等于 NO_ID，该 root被设置为源。一个虚拟后代是一个虚构视图，为无障碍目的，将自己报告为视图层次的一部分。该操作可以使绘制复杂内容的自定义视图，将自己报告为虚拟视图树，然后传递其逻辑结构。
            info.setText(Getter.text); // 设置该节点的文本。
            info.setTextSelection(Getter._int, Getter._int); // 设置文本选择的起始和结尾。
            info.setViewIdResourceName(Getter.text); // 设置源视图id的资源名称
            info.setVisibleToUser(Getter._boolean); // 设置该节点对用户可见。
            info.toString(); // 返回一个代表对象的字符串。 getClass().getName() + '@' + Integer.toHexString(hashCode())
            info.writeToParcel(Getter.parcel, Getter._int);// 封装该对象到一个包中。
        }

        //================================================ API 21 ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            info.getMaxTextLength(); // 返回该节点的最大文本长度。
            info.getActionList(); // 获取可以在该节点上执行的操作。
            info.removeAction(Getter._int); // 该方法在 API 级别 21 被弃用。
            info.setMaxTextLength(Getter._int); // 设置最大文本长度，或无限制时为-1。一般情况下，用来标识一个可编辑文本框有输入字符数目限制。

            info.getError(); //API Level 21 获取该节点的错误文本。
            info.setError(Getter.text); //API Level 21 设置该节点的错误文本。
            info.getWindow(); //API Level 21 获取该节点所属的窗口。AccessibilityWindowInfo
            info.removeAction(Getter.accessibilityAction); //API Level 21 移除一个可以在该节点上执行的操作。如果该操作未被添加到该节点，调用该方法没有任何效果。返回一个布尔值表示是否成功移除操作。
            info.removeChild(Getter.view, Getter._int); //API Level 21 移除给定根节点的一个虚拟子元素。如果子元素不是之前被添加到该节点的，调用该方法无效果。 返回一个布尔值表示是否存在子元素。
            info.removeChild(Getter.view); //API Level 21 移除一个子元素。如果子元素先前未被添加到该节点，调用该方法无效果。
        }

        //================================================ API 22 ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            info.getTraversalAfter(); //API Level 22 当前节点被访问后，获取无障碍遍历中的下一个节点。一个屏幕阅读器必须在访问该节点内容之前，访问其他节点的内容。如果存在，返回后续节点，否则，返回 null。
            info.getTraversalBefore(); //API Level 22 当前节点被访问后，获取无障碍遍历中的上一个节点。屏幕阅读器必须访问该节点的信息，在访问先前节点内容之前。
            info.setTraversalAfter(Getter.view); //API Level 22 设置无障碍遍历中下一个被访问的视图。一个屏幕阅读器在访问该节点内容之前，必须访问另一个节点的内容。
            info.setTraversalAfter(Getter.view, Getter._int); //API Level 22设置无障碍遍历中下一个被访问的视图。一个屏幕阅读器在访问该节点内容之前，必须访问另一个节点的内容。如果 virtualDescendantId 等于 NO_ID，root被设置为前任。一个虚拟后代是一个虚构视图，为无障碍目的，将自己报告为视图层次的一部分。该操作可以使绘制复杂内容的自定义视图，将自己报告为虚拟视图树，然后传递其逻辑结构。
            info.setTraversalBefore(Getter.view); //API Level 22 设置无障碍遍历中当前访问节点的上一个视图。一个屏幕阅读器在访问上一个节点之前，必须访问该节点的内容。
            info.setTraversalBefore(Getter.view, Getter._int); //API Level 22 设置无障碍遍历中当前访问节点的上一个视图。一个屏幕阅读器在访问上一个节点之前，必须访问该节点的内容。如果virtualDescendantId 等于 NO_ID，root被设置为后任。一个虚拟后代是一个虚构视图，为无障碍目的，将自己报告为视图层次的一部分。该操作可以使绘制复杂内容的自定义视图，将自己报告为虚拟视图树，然后传递其逻辑结构。
        }

        //================================================ API 23 ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            info.setContextClickable(Getter._boolean); // 设置该节点文本可点击。
        }

        //================================================ API 24 ================================================//
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            info.setImportantForAccessibility(Getter._boolean); //API Level 24 设置该节点对无障碍很重要。
            info.setDrawingOrder(Getter._int); //API Level 24 设置该节点相关视图的绘制顺序。
            info.getDrawingOrder(); //API Level 24。获取该节点中视图的相对绘制顺序。绘制顺序只决定于节点的父级，所以该索引只与其兄弟姐妹相关。在一些情景下，绘制顺序是基本同步的，所以两个兄弟姐妹的返回值相同是可能的。返回值会被跳过也是可能的。
            info.isImportantForAccessibility(); //API Level 24 返回该节点是否来源于一个对无障碍相当重要的视图。
        }
    }
}
