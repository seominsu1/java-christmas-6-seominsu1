package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BadgeTest {
    @DisplayName("배지 기준금액에 해당하는 배지 반환")
    @Test
    void findBadgeByStandardMoney() {
        int standardMoney = 5000;
        Badge expected = Badge.STAR;

        assertThat(Badge.findBadgeByStandardMoney(standardMoney)).isEqualTo(expected);
    }

    @DisplayName("가장 가치있는 배지 반환")
    @Test
    void findWorthBadge() {
        List<Badge> badges = new ArrayList<>();
        badges.add(Badge.STAR);
        badges.add(Badge.SANTA);
        Badge expected = Badge.SANTA;

        assertThat(Badge.findWorthBadge(badges)).isEqualTo(expected);
    }

    @DisplayName("총혜택금액으로 해당하는 배지 반환")
    @Test
    void findBadgeByTotalAmount() {
        int DiscountAmount = 30000;
        Badge expected = Badge.SANTA;

        assertThat(Badge.findBadgeByAmount(DiscountAmount)).isEqualTo(expected);
    }
}